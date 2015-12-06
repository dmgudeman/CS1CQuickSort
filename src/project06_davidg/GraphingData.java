package project06_davidg;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Line2D;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
// 
//public class GraphingData extends JPanel {
////    int[] data2 = {
////        21, 14, 18, 03, 86, 88, 74, 87, 54, 77,
////        61, 55, 48, 60, 49, 36, 38, 27, 20, 18
////    };
//    public int[] data = {};
//    final int PAD = 1;
//    public GraphingData(int[] data)
//    {
//       this.data = data;
//       JFrame f = new JFrame();
//       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       f.add(paintComponent)
//       f.setSize(10,10);
//       f.setLocation(10,10);
//       f.setVisible(true);
//      
//    }
// 
//    protected void paintComponent(Graphics g, int[] data) {
//        
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D)g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                            RenderingHints.VALUE_ANTIALIAS_ON);
//        int w = getWidth();
//        int h = getHeight();
//        // Draw ordinate.
//        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
//        // Draw abcissa.
//        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
//        double xInc = (double)(w - 2*PAD)/(data.length-1);
//        double scale = (double)(h - 2*PAD)/getMax(data);
//        // Mark data points.
//        g2.setPaint(Color.red);
//        for(int i = 0; i < data.length; i++) {
//            double x = PAD + i*xInc;
//            System.out.println("DOUBLE X " + x);
//            double y = h - PAD - scale*data[i];
//            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
//        }
//    }
// 
//    private int getMax(int[] data) {
//        int max = -Integer.MAX_VALUE;
//        for(int i = 0; i < data.length; i++) {
//            if(data[i] > max)
//                max = data[i];
//        }
//        return max;
//    }
// 
////    public static void make(int[] data) {
////        JFrame f = new JFrame();
////        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        f.add(new GraphingData(data));
////        f.setSize(10,10);
////        f.setLocation(10,10);
////        f.setVisible(true);
////    }
//}