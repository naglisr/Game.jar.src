 import java.awt.PopupMenu;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 
 class MouseHandler extends MouseAdapter {
   private PopupMenu popupMenu;
   int id;
   
   public MouseHandler(PopupMenu paramPopupMenu, int paramInt) {
     this.popupMenu = paramPopupMenu; this.id = paramInt;
   }
   
   public void mousePressed(MouseEvent paramMouseEvent) {
     if (paramMouseEvent.isPopupTrigger()) {
       this.popupMenu.show(paramMouseEvent.getComponent(), paramMouseEvent.getX(), paramMouseEvent.getY());
       Madness.textid = this.id;
       paramMouseEvent.consume();
     } 
   }
 
   
   public void mouseReleased(MouseEvent paramMouseEvent) {
     if (paramMouseEvent.isPopupTrigger()) {
       this.popupMenu.show(paramMouseEvent.getComponent(), paramMouseEvent.getX(), paramMouseEvent.getY());
       Madness.textid = this.id;
       paramMouseEvent.consume();
     } 
   }
 }


