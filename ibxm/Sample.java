 package ibxm;
 
 
 
 public class Sample
 {
   public static final int FP_SHIFT = 15;
   public static final int FP_ONE = 32768;
   public static final int FP_MASK = 32767;
   public static final int C2_PAL = 8287;
   public static final int C2_NTSC = 8363;
   public String name = "";
   public int volume = 0; public int panning = -1; public int relNote = 0; public int fineTune = 0; public int c2Rate = 8363;
   private int loopStart = 0; private int loopLength = 0;
   
   private short[] sampleData;
   
   private static final int LOG2_FILTER_TAPS = 4;
   private static final int FILTER_TAPS = 16;
   private static final int DELAY = 8;
   private static final int LOG2_TABLE_ACCURACY = 4;
   private static final int TABLE_ACCURACY = 16;
   private static final int TABLE_INTERP_SHIFT = 11;
   private static final int TABLE_INTERP_ONE = 2048;
   private static final int TABLE_INTERP_MASK = 2047;
   private static final int LOG2_NUM_TABLES = 3;
   private static final int NUM_TABLES = 8;
   private static final short[][] SINC_TABLES = calculateSincTables();
   
   private static short[][] calculateSincTables() {
     short[][] sincTables = new short[8][];
     for (int tableIdx = 0; tableIdx < 8; tableIdx++) {
       sincTables[tableIdx] = calculateSincTable(1.0D / (tableIdx + 1));
     }
     return sincTables;
   }
   
   private static short[] calculateSincTable(double lowpass) {
     short[] sincTable = new short[272];
     double windDT = -0.39269908169872414D;
     double sincDT = -3.141592653589793D;
     int tableIdx = 0;
     for (int tableY = 0; tableY <= 16; tableY++) {
       double fracT = tableY / 16.0D;
       double sincT = Math.PI * (7.0D + fracT);
       double windT = Math.PI + sincT * 2.0D / 16.0D;
       for (int tableX = 0; tableX < 16; tableX++) {
         double sincY = lowpass;
         if (sincT != 0.0D) {
           sincY = Math.sin(lowpass * sincT) / sincT;
         }
         
         double windY = 0.35875D;
         windY -= 0.48829D * Math.cos(windT);
         windY += 0.14128D * Math.cos(windT * 2.0D);
         windY -= 0.01168D * Math.cos(windT * 3.0D);
         sincTable[tableIdx++] = (short)(int)Math.round(sincY * windY * 32767.0D);
         sincT += sincDT;
         windT += windDT;
       } 
     } 
     return sincTable;
   }
   
   public void setSampleData(short[] sampleData, int loopStart, int loopLength, boolean pingPong) {
     int sampleLength = sampleData.length;
     
     if (loopStart < 0 || loopStart > sampleLength)
       loopStart = sampleLength; 
     if (loopLength < 0 || loopStart + loopLength > sampleLength)
       loopLength = sampleLength - loopStart; 
     sampleLength = loopStart + loopLength;
     
     loopStart += 8;
     
     int newSampleLength = 8 + sampleLength + (pingPong ? loopLength : 0) + 16;
     short[] newSampleData = new short[newSampleLength];
     System.arraycopy(sampleData, 0, newSampleData, 8, sampleLength);
     sampleData = newSampleData;
     if (pingPong) {
       
       int loopEnd = loopStart + loopLength;
       for (int i = 0; i < loopLength; i++)
         sampleData[loopEnd + i] = sampleData[loopEnd - i - 1]; 
       loopLength *= 2;
     } 
     
     for (int idx = loopStart + loopLength, end = idx + 16; idx < end; idx++)
       sampleData[idx] = sampleData[idx - loopLength]; 
     this.sampleData = sampleData;
     this.loopStart = loopStart;
     this.loopLength = loopLength;
   }
 
   
   public void resampleNearest(int sampleIdx, int sampleFrac, int step, int leftGain, int rightGain, int[] mixBuffer, int offset, int length) {
     int loopLen = this.loopLength;
     int loopEnd = this.loopStart + loopLen;
     sampleIdx += 8;
     if (sampleIdx >= loopEnd)
       sampleIdx = normaliseSampleIdx(sampleIdx); 
     short[] data = this.sampleData;
     int outIdx = offset << 1;
     int outEnd = offset + length << 1;
     while (outIdx < outEnd) {
       if (sampleIdx >= loopEnd) {
         if (loopLen < 2)
           break;  for (; sampleIdx >= loopEnd; sampleIdx -= loopLen);
       } 
       int y = data[sampleIdx];
       mixBuffer[outIdx++] = mixBuffer[outIdx++] + (y * leftGain >> 15);
       mixBuffer[outIdx++] = mixBuffer[outIdx++] + (y * rightGain >> 15);
       sampleFrac += step;
       sampleIdx += sampleFrac >> 15;
       sampleFrac &= 0x7FFF;
     } 
   }
 
   
   public void resampleLinear(int sampleIdx, int sampleFrac, int step, int leftGain, int rightGain, int[] mixBuffer, int offset, int length) {
     int loopLen = this.loopLength;
     int loopEnd = this.loopStart + loopLen;
     sampleIdx += 8;
     if (sampleIdx >= loopEnd)
       sampleIdx = normaliseSampleIdx(sampleIdx); 
     short[] data = this.sampleData;
     int outIdx = offset << 1;
     int outEnd = offset + length << 1;
     while (outIdx < outEnd) {
       if (sampleIdx >= loopEnd) {
         if (loopLen < 2)
           break;  for (; sampleIdx >= loopEnd; sampleIdx -= loopLen);
       } 
       int c = data[sampleIdx];
       int m = data[sampleIdx + 1] - c;
       int y = (m * sampleFrac >> 15) + c;
       mixBuffer[outIdx++] = mixBuffer[outIdx++] + (y * leftGain >> 15);
       mixBuffer[outIdx++] = mixBuffer[outIdx++] + (y * rightGain >> 15);
       sampleFrac += step;
       sampleIdx += sampleFrac >> 15;
       sampleFrac &= 0x7FFF;
     } 
   }
 
   
   public void resampleSinc(int sampleIdx, int sampleFrac, int step, int leftGain, int rightGain, int[] mixBuffer, int offset, int length) {
     int tableIdx = 0;
     if (step > 32768) {
       
       tableIdx = (step >> 15) - 1;
       if (tableIdx >= 8) {
         tableIdx = 7;
       }
     } 
     short[] sincTable = SINC_TABLES[tableIdx];
     int loopLen = this.loopLength;
     int loopEnd = this.loopStart + loopLen;
     if (sampleIdx >= loopEnd)
       sampleIdx = normaliseSampleIdx(sampleIdx); 
     short[] data = this.sampleData;
     int outIdx = offset << 1;
     int outEnd = offset + length << 1;
     while (outIdx < outEnd) {
       if (sampleIdx >= loopEnd) {
         if (loopLen < 2)
           break;  for (; sampleIdx >= loopEnd; sampleIdx -= loopLen);
       } 
       int tableIdx1 = sampleFrac >> 11 << 4;
       int tableIdx2 = tableIdx1 + 16;
       int a1 = 0, a2 = 0;
       for (int tap = 0; tap < 16; tap++) {
         a1 += sincTable[tableIdx1 + tap] * data[sampleIdx + tap];
         a2 += sincTable[tableIdx2 + tap] * data[sampleIdx + tap];
       } 
       a1 >>= 15;
       a2 >>= 15;
       int y = a1 + ((a2 - a1) * (sampleFrac & 0x7FF) >> 11);
       mixBuffer[outIdx++] = mixBuffer[outIdx++] + (y * leftGain >> 15);
       mixBuffer[outIdx++] = mixBuffer[outIdx++] + (y * rightGain >> 15);
       sampleFrac += step;
       sampleIdx += sampleFrac >> 15;
       sampleFrac &= 0x7FFF;
     } 
   }
   
   public int normaliseSampleIdx(int sampleIdx) {
     int loopOffset = sampleIdx - this.loopStart;
     if (loopOffset > 0) {
       sampleIdx = this.loopStart;
       if (this.loopLength > 1) sampleIdx += loopOffset % this.loopLength; 
     } 
     return sampleIdx;
   }
   
   public boolean looped() {
     return (this.loopLength > 1);
   }
   
   public void toStringBuffer(StringBuffer out) {
     out.append("Name: " + this.name + '\n');
     out.append("Volume: " + this.volume + '\n');
     out.append("Panning: " + this.panning + '\n');
     out.append("Relative Note: " + this.relNote + '\n');
     out.append("Fine Tune: " + this.fineTune + '\n');
     out.append("Loop Start: " + this.loopStart + '\n');
     out.append("Loop Length: " + this.loopLength + '\n');
   }
 }


