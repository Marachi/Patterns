package adapter;

/**
 * Created by Potaychuk Sviatoslav on 22.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        VectorAdapterFromRaster v1 = new VectorAdapterFromRaster();
        v1.drawSquare();
        v1.drawLine();

    }
}
interface  VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine(){
        System.out.println("drawRasterLine");
    }
    void drawRasterSquare(){
        System.out.println("drawRasterSquare");
    }
}
class VectorAdapterFromRaster extends  RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}