package sg.com.simplus.mvms.service.businessservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.SAXPrettyOutputter;
import org.kabeja.xml.SAXSerializer;
import sg.com.simplus.mvms.data.dto.DxfParam;

@Service
public class UploadBusinessService {

    private static double standard_tile_size_in_latlon; //Value is 256*Width in latlon/Width in pixels of ENC Z1.jpg.cfg
    //private static final String GENERATION_MODE = "DXF"; //ENC or DXF
    private static final int tileSize = 256; // Tile size in pixel
    private static final int max_png_width = 6424; // Value must not be changed
    private static final int max_png_height = 5804; // Value must not be changed

    @Value("${dxf.converter.repository}")
    String repository;
    @Value("${dxf.converter.filePath}")
    String filePath;
    @Value("${dxf.converter.processFilePath}")
    String processFilePath;
    @Value("${dxf.converter.tilePath}")
    String tilePath;


    public void convert(DxfParam dxfParam, String filename) {
        System.out.println("UploadBusinessService convert filename: "+filename);


        /**
         * Global Final Params
         */
        String GENERATION_MODE = dxfParam.getGenerationModeStr();

        filePath = repository + filePath;
        processFilePath = repository + processFilePath;
        tilePath = repository + tilePath;
        System.out.println("UploadBusinessService tilePath  : "+tilePath);

        double overlay_min_longitude = dxfParam.getOverlayMinLongitudeDbl();
        System.out.println("UploadBusinessService overlay_min_longitude  : "+overlay_min_longitude);
        double overlay_max_longitude = dxfParam.getOverlayMaxLongitudeDbl();
        double overlay_min_latitude = dxfParam.getOverlayMinLatitudeDbl();
        double overlay_max_latitude = dxfParam.getOverlayMaxLatitudeDbl();

        double overlay_max_pixel_x = dxfParam.getOverlayMaxPixelXDbl();
        double overlay_min_pixel_x = dxfParam.getOverlayMinPixelXDbl();
        double overlay_max_pixel_y = dxfParam.getOverlayMaxPixelYDbl();
        double overlay_min_pixel_y = dxfParam.getOverlayMinPixelYDbl();

        double baseMap_min_longitude = dxfParam.getBaseMapMinLongitudeDbl();
        double baseMap_max_longitude = dxfParam.getBaseMapMaxLongitudeDbl();
        double baseMap_min_latitude = dxfParam.getBaseMapMinLatitudeDbl();
        double baseMap_max_latitude = dxfParam.getBaseMapMaxLatitudeDbl();

        int displayScreenWidth = dxfParam.getDisplayScreenWidthInt();
        int displayScreenHeight = dxfParam.getDisplayScreenHeightInt();
        String string_zoomLevels = dxfParam.getZoomLevelsStr();
        System.out.println("UploadBusinessService string_zoomLevels  : "+string_zoomLevels);

        String string_params = "-----[Converter Configuration]------\n"
                + "Repository Drive:" + repository + "\n"
                + "Raw DXF Dir:" + filePath + "\n"
                + "Processed DXF PNG Dir:" + processFilePath + "\n"
                + "TEMP DXF Dir:" + tilePath + "\n"
                + "DXF Name:" + filename + "\n"
                + "--------------------------------\n"
                + "Overlay Min Longitude (Left):" + overlay_min_longitude + "\n"
                + "Overlay Max Longitude (Right):" + overlay_max_longitude + "\n"
                + "Overlay Min Latitude (Bottom):" + overlay_min_latitude + "\n"
                + "Overlay Max Latitude (Top):" + overlay_max_latitude + "\n"
                + "---------------------------------\n"
                + "Overlay Min X (Left):" + overlay_min_pixel_x + "\n"
                + "Overlay Max X (Right):" + overlay_max_pixel_x + "\n"
                + "Overlay Min Y (Bottom):" + overlay_min_pixel_y + "\n"
                + "Overlay Max Y (Top):" + overlay_max_pixel_y + "\n"
                + "---------------------------------\n"
                + "Base Layer Min Longitude (Left):" + baseMap_min_longitude + "\n"
                + "Base Layer Max Longitude (Right):" + baseMap_max_longitude + "\n"
                + "Base Layer Min Latitude (Bottom):" + baseMap_min_latitude + "\n"
                + "Base Layer Max Latitude (Top):" + baseMap_max_latitude + "\n"
                + "---------------------------------\n"
                + "Base Layer Width:" + displayScreenWidth + "\n"
                + "Base Layer Height:" + displayScreenHeight + "\n"
                + "---------------------------------\n";
        System.out.println(string_params);

        ArrayList<Integer> ar = new ArrayList<>();
        for (String string_zoomLevel : string_zoomLevels.split(",", -1)) {
            ar.add(Integer.valueOf(string_zoomLevel));
        }
        System.out.println("zoom ar: "+ar);

        /**
         * #256*[Distance in latlon/Distance in pixels(1.2155564/1919)]
         */
        double standard_tile_size_in_latlona = ((overlay_max_longitude - overlay_min_longitude) / (double) displayScreenWidth) * 256d;
        standard_tile_size_in_latlon = ((baseMap_max_longitude - baseMap_min_longitude) / (double) displayScreenWidth) * 256d;
        System.out.println("  standard_tile_size_in_latlon: "+standard_tile_size_in_latlon);
        System.out.println("GENERATION_MODE: "+GENERATION_MODE);

        if (GENERATION_MODE.equals("DXF")) {
            System.out.print("DXF Tiles Generation Started...\n");

            //Rectangle rect =  parseFileToSVG(filePath, processFilePath, filename + ".dxf", filename, 500, overlay_max_pixel_x, overlay_min_pixel_x, overlay_max_pixel_y, overlay_min_pixel_y);
            Rectangle rect =  parseFileToSVG(filePath, processFilePath, filename, filename, 500, overlay_max_pixel_x, overlay_min_pixel_x, overlay_max_pixel_y, overlay_min_pixel_y);
            System.out.print("rect: "+rect);
            if (rect != null) {
                try {
                    convertSVGToPNG(processFilePath + filename, processFilePath + filename, rect, displayScreenWidth, displayScreenHeight, baseMap_min_longitude, baseMap_min_latitude, baseMap_max_longitude, baseMap_max_latitude, overlay_min_longitude, overlay_max_longitude, overlay_min_latitude, overlay_max_latitude, ar, tileSize, max_png_width, max_png_height);
                    ENCMapTiling(processFilePath, filename, ".png", tilePath, ar, displayScreenWidth, displayScreenHeight, baseMap_min_longitude, baseMap_min_latitude, baseMap_max_longitude, baseMap_max_latitude, overlay_min_longitude, overlay_max_longitude, overlay_min_latitude, overlay_max_latitude);
                    System.out.println("Conversion Done...[END]");
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    System.out.println("Conversion FAILED!...[END]");
                }
            }
        } else if (GENERATION_MODE.equals("ENC")) {
            System.out.print("ENC Tiles Generation Started...\n");
            try {
                ENCMapTiling(processFilePath, filename, ".jpg", tilePath, ar, displayScreenWidth, displayScreenHeight, baseMap_min_longitude, baseMap_min_latitude, baseMap_max_longitude, baseMap_max_latitude, baseMap_min_longitude, baseMap_max_longitude, baseMap_min_latitude, baseMap_max_latitude);
                System.out.println("Conversion Done...[END]");
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
                System.out.println("Conversion FAILED!...[END]");
            }
        }
    }

    /**
     * Convert the DXF file to SVG file
     */
    public   Rectangle parseFileToSVG(String stringSourcePath, String stringDestPath, String sourceFileName, String destFileName, double width,
                                           double overlay_max_pixel_x, double overlay_min_pixel_x, double overlay_max_pixel_y, double overlay_min_pixel_y) {
        if (!sourceFileName.contains(".dxf")) {
            return null;
        }
        System.out.println("parseFileToSVG()  ");
        System.out.println("overlay_max_pixel_x: "+overlay_max_pixel_x);
        System.out.println("overlay_min_pixel_x: "+overlay_min_pixel_x);
        System.out.println("overlay_max_pixel_y: "+overlay_max_pixel_y);
        System.out.println("overlay_min_pixel_y: "+overlay_min_pixel_y);

        System.out.println("sourceFileName: "+sourceFileName);

        File file = new File(stringSourcePath + sourceFileName);
        System.out.println("file getAbsolutePath: "+file.getAbsolutePath());
        if (!file.exists()) {
            return null;
        }


        file = new File(stringDestPath + destFileName + ".svg");
        if (file.exists()) {
            file.delete();
        }
        System.out.println("file destination path: "+file.getAbsolutePath());
        try {
            //TO DO: Set output file
            file = new File(stringDestPath);
            if (!file.exists()) {
                file.mkdirs();
            }

            //TO DO: Set source file
            FileOutputStream outStream = new FileOutputStream(stringDestPath + destFileName + ".svg");
            System.out.println("outStream  path: "+stringDestPath + destFileName + ".svg");
            InputStream in = new FileInputStream(stringSourcePath + sourceFileName);
            System.out.println("InputStream  path: "+stringSourcePath + sourceFileName);
            Parser dxfParser = ParserBuilder.createDefaultParser();
            System.out.println("dxfParser  name: "+dxfParser.getName());
            dxfParser.parse(in, "");
            DXFDocument doc = dxfParser.getDocument();

            SVGGenerator generator = new SVGGenerator();
            SAXSerializer out = new SAXPrettyOutputter();

            out.setOutput(outStream);
            System.out.println("generator : "+generator.toString());
            generator.generate(doc, out, new HashMap());
            return new Rectangle((int) overlay_min_pixel_x, (int) (-overlay_max_pixel_y), (int) (overlay_max_pixel_x - overlay_min_pixel_x), (int) (overlay_max_pixel_y - overlay_min_pixel_y));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }

    }

    public   void convertSVGToPNG(String inputFilename, String outputFilename, Rectangle rect,
                                       int imgWidth,
                                       int imgHeight,
                                       double base_left,
                                       double base_bottom,
                                       double base_right,
                                       double base_top,
                                       double dxf_x_min,
                                       double dxf_x_max,
                                       double dxf_y_min,
                                       double dxf_y_max,
                                       ArrayList<Integer> ar,
                                       int tileSize,
                                       int max_png_width,
                                       int max_png_height
    ) throws Exception {
        System.out.println("convertSVGToPNG inputFilename: "+inputFilename);
        System.out.println("convertSVGToPNG outputFilename: "+outputFilename);

        int max_points_on_image = max_png_width * max_png_height;
        for (int zIdx = 0; zIdx < ar.size(); zIdx++) {
            int zoom = ar.get(zIdx);
            int total_png_width = convertTileSizeFromLatLonToPixel(base_right - base_left, imgWidth * zoom, dxf_x_max - dxf_x_min);
            int total_png_height = convertTileSizeFromLatLonToPixel(base_top - base_bottom, imgHeight * zoom, dxf_y_max - dxf_y_min);

            int n_png_img_width = 1;
            int n_png_img_height = 1;
            int png_width = max_png_width;
            if ((total_png_width * total_png_height) > max_points_on_image) {
                png_width = max_points_on_image / total_png_height;
                n_png_img_width = total_png_width / (png_width - tileSize) + 1;
            }

            int newX = 0;//SVG image left
            int newW = 0;//SVG image width
            int w = 0;//PNG image
            int x = 0;//PNG image width
            double lonlat_left = 0;//latlon left
            double lonlat_width = 0;//latlon width
            for (int idx_png_width = 0; idx_png_width < n_png_img_width; idx_png_width++) {
                if (n_png_img_width == 1) {
                    w = total_png_width;
                    newX = rect.x;
                    newW = rect.width;
                    lonlat_left = dxf_x_min;
                    lonlat_width = dxf_x_max - dxf_x_min;
                } else if (idx_png_width == 0) {
                    x = 0;
                    w = png_width;
                    newX = rect.x;
                    newW = (int) (((float) w / (float) total_png_width) * (float) rect.width);
                    lonlat_left = dxf_x_min;
                    lonlat_width = ((double) w / (double) total_png_width) * (dxf_x_max - dxf_x_min);
                } else if (idx_png_width < n_png_img_width - 1) {
                    x += w - tileSize;
                    w = png_width;
                    newX = rect.x + (int) (((float) x / (float) total_png_width) * (float) rect.width);
                    newW = (int) (((float) w / (float) total_png_width) * (float) rect.width);
                    lonlat_left = convertPixelToLatLon(dxf_x_min, dxf_x_max, 0, total_png_width, x);
                    lonlat_width = ((double) w / (double) total_png_width) * (dxf_x_max - dxf_x_min);
                } else {
                    x += w - tileSize;
                    w = total_png_width - x;
                    newX = rect.x + (int) (((float) x / (float) total_png_width) * (float) rect.width);
                    newW = (int) (((float) w / (float) total_png_width) * (float) rect.width);
                    lonlat_left = convertPixelToLatLon(dxf_x_min, dxf_x_max, 0, total_png_width, x);
                    lonlat_width = ((double) w / (double) total_png_width) * (dxf_x_max - dxf_x_min);
                }

                int newY = 0;
                int newH = 0;
                int h = 0;
                double lonlat_top = 0;
                double lonlat_height = 0;
                for (int idx_png_height = 0; idx_png_height < n_png_img_height; idx_png_height++) {
                    if (n_png_img_height == 1) {
                        newY = rect.y;
                        newH = rect.height;
                        h = total_png_height;
                        lonlat_top = dxf_y_max;
                        lonlat_height = dxf_y_max - dxf_y_min;
                    } else if (idx_png_height == 0) {
                        newY = rect.y;
                        h = max_png_height;
                        newH = (int) (((float) h / (float) total_png_height) * (float) rect.height);
                        lonlat_top = dxf_y_max;
                        lonlat_height = ((double) h / (double) total_png_height) * (dxf_y_max - dxf_y_min);
                    } else if (idx_png_height < n_png_img_height - 1) {
                        newY = rect.y + (int) ((float) ((max_png_height - tileSize) * idx_png_height * rect.height) / (float) total_png_height);
                        h = max_png_height;
                        newH = (int) (((float) h / (float) total_png_height) * (float) rect.height);
                        lonlat_top = convertPixelToLatLon(dxf_y_max, dxf_y_min, 0, total_png_height, (max_png_height - tileSize) * idx_png_height);
                        lonlat_height = ((double) h / (double) total_png_height) * (dxf_y_max - dxf_y_min);
                    } else {
                        newY = (max_png_height - tileSize) * idx_png_height;
                        h = total_png_height - newY;
                        lonlat_top = convertPixelToLatLon(dxf_y_max, dxf_y_min, 0, total_png_height, (max_png_height - tileSize) * idx_png_height);
                        lonlat_height = ((double) h / (double) total_png_height) * (dxf_y_max - dxf_y_min);
                        newY = rect.y + (int) ((float) ((max_png_height - tileSize) * idx_png_height * rect.height) / (float) total_png_height);
                        newH = (int) (((float) h / (float) total_png_height) * (float) rect.height);
                    }
                    try {
                        convertSVGToPNG(inputFilename + ".svg",
                                outputFilename + "Z" + zoom + "_" + idx_png_width + "_" + idx_png_height + ".png", w, h, new Rectangle(newX, newY, newW, newH), lonlat_left, lonlat_width, lonlat_top, lonlat_height
                        );
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public   void convertSVGToPNG(String inputFilename, String outputFilename, float w, float h, Rectangle aoi, double lonlat_left, double lonlat_width,
                                       double lonlat_top, double lonlat_height
    ) throws Exception {
        PrintWriter pw = null;
        try {
            PNGTranscoder trans = new PNGTranscoder();
            // Set hints to indicate the dimensions of the output image
            // and the input area of interest.
            trans.addTranscodingHint(PNGTranscoder.KEY_WIDTH,
                    w);
            trans.addTranscodingHint(PNGTranscoder.KEY_HEIGHT,
                    h);
            trans.addTranscodingHint(PNGTranscoder.KEY_AOI, aoi);

            // Transcode the file.
            String svgURI = new File(inputFilename).toURL().toString();
            TranscoderInput input = new TranscoderInput(svgURI);
            OutputStream ostream = new FileOutputStream(outputFilename);
            TranscoderOutput output = new TranscoderOutput(ostream);
            trans.transcode(input, output);

            // Flush and close the output.
            ostream.flush();
            ostream.close();

            System.out.println("java -Xmx2000m -jar batik-rasterizer.jar -a "
                    + aoi.x + "," + aoi.y + "," + aoi.width + "," + aoi.height
                    + " -w " + w + " -h " + h + "	"
                    + "-d " + outputFilename + "	"
                    + "-m image/png " + inputFilename);

            File file = new File(outputFilename + ".cfg");
            pw = new PrintWriter(file);
            pw.println(lonlat_left + "\t" + lonlat_width + "\t" + lonlat_top + "\t" + lonlat_height);
            pw.println(w + "\t" + h);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }

    private   void DXFMapTiling(String infoPath, String infofilename, String filePath, String dxfImageName, String tilePath, ArrayList<Integer> arrayList_zoomLevels,
                                     int imgWidth,
                                     int imgHeight,
                                     double base_left,
                                     double base_bottom,
                                     double base_right,
                                     double base_top,
                                     double dxf_x_min,
                                     double dxf_x_max,
                                     double dxf_y_min,
                                     double dxf_y_max
    ) throws IOException {

        int dxf_width = 0;
        int dxf_height = 0;
        String sourceImage = filePath + "dredging_areaZ1_0_0.png";
        {
            BufferedReader br = null;
            File sourceFile = new File(sourceImage);
            FileImageInputStream in = new FileImageInputStream(sourceFile);
            ImageReader reader = null;

            try {

                final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
                if (readers.hasNext()) {
                    reader = readers.next();
                    try {
                        reader.setInput(in, false, true);
                        dxf_width = reader.getWidth(0);
                        dxf_height = reader.getHeight(0);

                        if (dxf_width > 0 && dxf_height > 0) {

                            ImageReadParam readParameters = reader.getDefaultReadParam();
                            int size = 256;
                            int sourceChunkHeight = 256;
                            int sourceChunkWidth = 256;

                            ArrayList<Integer> cutting_position_x = null;
                            ArrayList<Integer> cutting_position_y = null;

                            {
                                Dimension tileDim = new Dimension(size, size);

                                double baseChunkWidth_latlon = standard_tile_size_in_latlon;
                                double baseChunkHeight_latlon = standard_tile_size_in_latlon;

                                for (int zIdx = 0; zIdx < arrayList_zoomLevels.size(); zIdx++) {
                                    int zoomLevel = arrayList_zoomLevels.get(zIdx);
                                    double baseChunkHeight_latlon_atZoomLevel = baseChunkHeight_latlon / (double) (zoomLevel);
                                    double baseChunkWidth_latlon_atZoomLevel = baseChunkWidth_latlon / (double) (zoomLevel);

                                    sourceChunkHeight = convertTileSizeFromLatLonToPixel(dxf_y_max - dxf_y_min, dxf_height, baseChunkHeight_latlon_atZoomLevel);
                                    sourceChunkWidth = convertTileSizeFromLatLonToPixel(dxf_x_max - dxf_x_min, dxf_width, baseChunkWidth_latlon_atZoomLevel);
                                    Dimension sourceTileDim = new Dimension(sourceChunkWidth, sourceChunkHeight);

                                    cutting_position_x = getCuttingPosition(base_left, baseChunkWidth_latlon_atZoomLevel, dxf_x_max, dxf_x_min, dxf_width, 0);
                                    cutting_position_y = getCuttingPosition(base_bottom, baseChunkHeight_latlon_atZoomLevel, dxf_y_max, dxf_y_min, 0, dxf_height);

                                    int x_offset = (int) ((dxf_x_min - base_left) / baseChunkWidth_latlon_atZoomLevel);
                                    int y_offset = (int) ((dxf_y_min - base_bottom) / baseChunkHeight_latlon_atZoomLevel);

                                    int n_cutting_pos_x = cutting_position_x.size();
                                    int n_cutting_pos_y = cutting_position_y.size();
                                    for (int x_idx = 0; x_idx <= n_cutting_pos_x; x_idx++) {
                                        String destFolder = tilePath + String.format("%d\\%d", zoomLevel, (x_offset + x_idx));
                                        File f = new File(destFolder);
                                        if (f.exists() && f.isDirectory()) {
                                            purgeDirectory(f);
                                        } else {
                                            f.mkdirs();
                                        }
                                        int w = 0;
                                        int x = 0;

                                        int dx1 = 0;
                                        int dx2 = dx1 + tileDim.width;
                                        int sx1 = 0;
                                        int sx2 = w;

                                        if (x_idx == 0) {
                                            w = cutting_position_x.get(0);
                                            x = 0;
                                            sx1 = 0;
                                            sx2 = w;
                                            dx1 = tileDim.width - (int) ((double) w * ((double) tileDim.width / (double) sourceTileDim.width));
                                            dx2 = tileDim.width;

                                        } else if (x_idx == n_cutting_pos_x) {
                                            x = cutting_position_x.get(n_cutting_pos_x - 1);
                                            w = dxf_width - x;
                                            sx1 = 0;
                                            sx2 = w;
                                            dx1 = 0;
                                            dx2 = (int) ((double) w * ((double) tileDim.width / (double) sourceTileDim.width));
                                        } else {
                                            x = cutting_position_x.get(x_idx - 1);
                                            w = cutting_position_x.get(x_idx) - x;
                                            sx1 = 0;
                                            sx2 = w;
                                            dx1 = 0;
                                            dx2 = tileDim.width;
                                        }
                                        readParameters.setSourceRegion(new Rectangle(x, 0, w, dxf_height));
                                        BufferedImage tile = reader.read(0, readParameters);
                                        for (int y_idx = 0; y_idx <= n_cutting_pos_y; y_idx++) {
                                            int type = tile.getType();
                                            BufferedImage bufferedImage = new BufferedImage(tileDim.width, tileDim.height, type);
                                            // draws the image chunk
                                            Graphics2D gr = bufferedImage.createGraphics();
                                            int h = 0;
                                            int y = 0;
                                            int dy1 = 0;
                                            int dy2 = 0;
                                            int sy1 = 0;
                                            int sy2 = y;
                                            if (y_idx == 0) {
                                                y = cutting_position_y.get(y_idx);
                                                h = dxf_height - y;
                                                sy1 = y;
                                                sy2 = dxf_height;
                                                dy1 = 0;
                                                dy2 = (int) ((double) h * ((double) tileDim.height / (double) sourceTileDim.height));
//                                                dy1 = tileDim.height - (int) ((double) h * ((double) tileDim.height / (double) sourceTileDim.height));
//                                                dy2 = tileDim.height;
//                                                sy1 = 0;
//                                                sy2 = h;
                                            } else if (y_idx == n_cutting_pos_y) {
                                                y = 0;
                                                h = cutting_position_y.get(n_cutting_pos_y - 1);
                                                sy1 = 0;
                                                sy2 = h;

                                                dy1 = tileDim.height - (int) ((double) h * ((double) tileDim.height / (double) sourceTileDim.height));;
                                                dy2 = tileDim.height;

                                            } else {
                                                y = cutting_position_y.get(y_idx);

                                                sy1 = y;
                                                sy2 = cutting_position_y.get(y_idx - 1);
                                                dy1 = 0;
                                                dy2 = tileDim.height;
                                            }

//                                    int out_x = 0;
//                                    int out_y = 0;
//                                    int out_w=tileDim.width;
//                                    int out_h = tileDim.height;
//                                        if (w != sourceTileDim.width) {
//                                            dx2 = dx1 + w;
//                                        }
//
//                                        if (h != sourceTileDim.height) {
//                                            int out_h = (int) ((float) h * ratio);
//                                            dy1 = tileDim.height - out_h;
//                                        }
                                            gr.drawImage(tile, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
                                            gr.dispose();
                                            ImageIO.write(bufferedImage, "PNG", new File(destFolder + "\\" + (y_offset + y_idx) + ".png"));

                                        }
                                    }
                                }

                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace(System.out);
                    } finally {
                        reader.dispose();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }

                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }

    }

    private   void ENCMapTiling(String filePath, String dxfImageName, String dxfImageName_extention, String tilePath, ArrayList<Integer> arrayList_zoomLevels,
                                     int baseImgWidth,
                                     int baseImgHeight,
                                     double base_left,
                                     double base_bottom,
                                     double base_right,
                                     double base_top,
                                     double dxf_x_min,
                                     double dxf_x_max,
                                     double dxf_y_min,
                                     double dxf_y_max
    ) throws IOException {
        System.out.println("ENCMapTiling filePath: "+filePath);
        int size = 256;
        int sourceChunkHeight = 256;
        int sourceChunkWidth = 256;
        Dimension tileDim = new Dimension(size, size);
        double baseChunkWidth_latlon = standard_tile_size_in_latlon;
        double baseChunkHeight_latlon = standard_tile_size_in_latlon;

        for (int idx = 0; idx < arrayList_zoomLevels.size(); idx++) {
            int zoomLevel = arrayList_zoomLevels.get(idx);
            double lon_min = dxf_x_min;
            double lon_max = dxf_x_max;
            double lat_min = dxf_y_min;
            double lat_max = dxf_y_max;
            int img_width = 0;
            int img_height = 0;

            int offset_x_cutting_position_0 = 0;
            int offset_x_cutting_position_1 = 0;
            int offset_y_cutting_position_0 = 0;
            int offset_y_cutting_position_1 = 0;

            int n_subimage_x = 1;
            int n_subimage_y = 1;
            boolean havesubx = false;
            boolean havesuby = false;

            n_subimage_x = getMaxIdx_X(filePath + dxfImageName, zoomLevel, dxfImageName_extention);
            havesubx = !(n_subimage_x < 0);
            if (!havesubx) {
                n_subimage_x = 1;
            } else {
                n_subimage_y = getMaxIdx_Y(filePath + dxfImageName, zoomLevel, dxfImageName_extention);
                havesuby = !(n_subimage_y < 0);
                if (!havesuby) {
                    n_subimage_y = 0;
                }
            }

            for (int sub_x = 0; sub_x < n_subimage_x; sub_x++) {
                for (int sub_y = 0; sub_y < n_subimage_y; sub_y++) {
                    String sourceImage = filePath + dxfImageName + "Z" + (zoomLevel);
//                                                  String sourceImage = filePath + dxfImageName + (zoomLevel);
                    if (havesubx) {
                        sourceImage += "_" + sub_x;
                    }
                    if (havesuby) {
                        sourceImage += "_" + sub_y;
                    }
                    sourceImage += dxfImageName_extention;

                    {
                        if (n_subimage_x <= 1) {
                            offset_x_cutting_position_0 = 0;
                            offset_x_cutting_position_1 = 0;
                        } else if (sub_x == 0) {
                            offset_x_cutting_position_0 = 0;
                            offset_x_cutting_position_1 = 1;
                        } else if (sub_x < n_subimage_x - 1) {
                            offset_x_cutting_position_0 = 1;
                            offset_x_cutting_position_1 = 1;
                        } else {
                            offset_x_cutting_position_0 = 1;
                            offset_x_cutting_position_1 = 0;
                        }

                        if (n_subimage_y <= 1) {
                            offset_y_cutting_position_0 = 0;
                            offset_y_cutting_position_1 = 0;
                        } else if (sub_y == 0) {
                            offset_y_cutting_position_0 = 1;
                            offset_y_cutting_position_1 = 0;
                        } else if (sub_y < n_subimage_y - 1) {
                            offset_y_cutting_position_0 = 1;
                            offset_y_cutting_position_1 = 1;
                        } else {
                            offset_y_cutting_position_0 = 0;
                            offset_y_cutting_position_1 = 1;
                        }
                    }
                    {
                        String sourceInfoFile = sourceImage + ".cfg";
                        System.out.println("ENCMapTiling sourceInfoFile : "+sourceInfoFile);

                        BufferedReader br = null;
                        File sourceFile = new File(sourceImage);
                        if (sourceFile.exists()) {
                            FileImageInputStream in = new FileImageInputStream(sourceFile);
                            ImageReader reader = null;

                            try {
                                br = new BufferedReader(new FileReader(sourceInfoFile));
                                String cur;
                                if ((cur = br.readLine()) != null) {
                                    String vals[] = cur.split("\t");
                                    if (vals.length == 4) {
                                        lon_min = Double.parseDouble(vals[0]);
                                        lon_max = lon_min + Double.parseDouble(vals[1]);
                                        lat_max = Double.parseDouble(vals[2]);
                                        lat_min = lat_max - Double.parseDouble(vals[3]);
                                    }
                                }

                                br.close();

                                final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
                                if (readers.hasNext()) {
                                    reader = readers.next();
                                    try {
                                        reader.setInput(in, false, true);
                                        img_width = reader.getWidth(0);
                                        img_height = reader.getHeight(0);

                                        if (img_width > 0 && img_height > 0) {

                                            ImageReadParam readParameters = reader.getDefaultReadParam();
                                            ArrayList<Integer> cutting_position_x = null;
                                            ArrayList<Integer> cutting_position_y = null;

                                            double baseChunkHeight_latlon_atZoomLevel = baseChunkHeight_latlon / (double) (zoomLevel);
                                            double baseChunkWidth_latlon_atZoomLevel = baseChunkWidth_latlon / (double) (zoomLevel);

                                            sourceChunkHeight = convertTileSizeFromLatLonToPixel(lat_max - lat_min, img_height, baseChunkHeight_latlon_atZoomLevel);
                                            sourceChunkWidth = convertTileSizeFromLatLonToPixel(lon_max - lon_min, img_width, baseChunkWidth_latlon_atZoomLevel);
                                            Dimension sourceTileDim = new Dimension(sourceChunkWidth, sourceChunkHeight);

                                            cutting_position_x = getCuttingPosition(base_left, baseChunkWidth_latlon_atZoomLevel, lon_max, lon_min, img_width, 0);
                                            cutting_position_y = getCuttingPosition(base_bottom, baseChunkHeight_latlon_atZoomLevel, lat_max, lat_min, 0, img_height);

                                            int x_offset = (int) ((lon_min - base_left) / baseChunkWidth_latlon_atZoomLevel);
                                            int y_offset = (int) ((lat_min - base_bottom) / baseChunkHeight_latlon_atZoomLevel);

                                            int n_cutting_pos_x = cutting_position_x.size();
                                            int n_cutting_pos_y = cutting_position_y.size();
                                            for (int x_idx = offset_x_cutting_position_0; x_idx <= n_cutting_pos_x - offset_x_cutting_position_1; x_idx++) {
                                                String destFolder = tilePath + String.format("%d\\%d", zoomLevel, (x_offset + x_idx));
                                                File f = new File(destFolder);
                                                if (f.exists() && f.isDirectory() && sub_y == 0) {
                                                    purgeDirectory(f);
                                                } else {
                                                    f.mkdirs();
                                                }
                                                int w = 0;
                                                int x = 0;

                                                int dx1 = 0;
                                                int dx2 = dx1 + tileDim.width;
                                                int sx1 = 0;
                                                int sx2 = w;

                                                if (x_idx == 0) {
                                                    w = cutting_position_x.get(0);
                                                    x = 0;
                                                    sx1 = 0;
                                                    sx2 = w;
                                                    dx1 = tileDim.width - (int) ((double) w * ((double) tileDim.width / (double) sourceTileDim.width));
                                                    dx2 = tileDim.width;

                                                } else if (x_idx == n_cutting_pos_x) {
                                                    x = cutting_position_x.get(n_cutting_pos_x - 1);
                                                    w = img_width - x;
                                                    sx1 = 0;
                                                    sx2 = w;
                                                    dx1 = 0;
                                                    dx2 = (int) ((double) w * ((double) tileDim.width / (double) sourceTileDim.width));
                                                } else {
                                                    x = cutting_position_x.get(x_idx - 1);
                                                    w = cutting_position_x.get(x_idx) - x;
                                                    sx1 = 0;
                                                    sx2 = w;
                                                    dx1 = 0;
                                                    dx2 = tileDim.width;
                                                }
                                                if (w < 0) {
                                                    System.out.println(x_idx + " " + sourceImage);
                                                }
                                                readParameters.setSourceRegion(new Rectangle(x, 0, w, img_height));
                                                BufferedImage tile = reader.read(0, readParameters);
//                                        for (int inv_y_idx = 0; inv_y_idx <= n_cutting_pos_y; inv_y_idx++) {
                                                for (int y_idx = offset_y_cutting_position_0; y_idx <= n_cutting_pos_y - offset_y_cutting_position_1; y_idx++) {
                                                    int type = tile.getType();
                                                    BufferedImage bufferedImage = new BufferedImage(tileDim.width, tileDim.height, type);
                                                    // draws the image chunk
                                                    Graphics2D gr = bufferedImage.createGraphics();

                                                    int h = 0;
                                                    int y = 0;
                                                    int dy1 = 0;
                                                    int dy2 = 0;
                                                    int sy1 = 0;
                                                    int sy2 = y;
                                                    if (y_idx == 0) {
                                                        y = cutting_position_y.get(y_idx);
                                                        h = img_height - y;
                                                        sy1 = y;
                                                        sy2 = img_height;
                                                        dy1 = 0;
                                                        dy2 = (int) ((double) h * ((double) tileDim.height / (double) sourceTileDim.height));
                                                    } else if (y_idx == n_cutting_pos_y) {
                                                        y = 0;
                                                        h = cutting_position_y.get(n_cutting_pos_y - 1);
                                                        sy1 = 0;
                                                        sy2 = h;

                                                        dy1 = tileDim.height - (int) ((double) h * ((double) tileDim.height / (double) sourceTileDim.height));;
                                                        dy2 = tileDim.height;

                                                    } else {
                                                        y = cutting_position_y.get(y_idx);

                                                        sy1 = y;
                                                        sy2 = cutting_position_y.get(y_idx - 1);
                                                        dy1 = 0;
                                                        dy2 = tileDim.height;
                                                    }
                                                    gr.drawImage(tile, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
                                                    gr.dispose();
                                                    System.out.println("drawImage: "+destFolder + "\\" + (y_offset + y_idx) + ".png");
                                                    ImageIO.write(bufferedImage, "PNG", new File(destFolder + "\\" + (y_offset + y_idx) + ".png"));
                                                }
                                            }
                                        }
                                    } catch (IOException ex) {
                                        ex.printStackTrace(System.out);
                                    } finally {
                                        reader.dispose();
                                    }
                                }
                            } catch (Exception ex) {
                                System.out.println(sourceImage);
                                ex.printStackTrace(System.out);
                            } finally {
                                try {
                                    if (in != null) {
                                        in.close();
                                    }
                                } catch (IOException ex) {
                                    ex.printStackTrace(System.out);
                                }
                                try {
                                    if (br != null) {
                                        br.close();
                                    }
                                } catch (IOException ex) {
                                    ex.printStackTrace(System.out);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private   int convertTileSizeFromLatLonToPixel(double latlon_size, int pixel_size, double latlon_tile_size) {
        return (int) (latlon_tile_size * (double) pixel_size / latlon_size);
    }

    private   double convertTileSizeFromPixelToLatLon(double latlon_size, int pixel_size, int pixel_tile_size) {
        return ((double) pixel_tile_size * latlon_size / (double) pixel_size);
    }

    private   double convertPixelToLatLon(double latlon1, double latlon2, int pixel1, int pixel2, int point_pixel) {
        return latlon1 + (double) ((double) (point_pixel - pixel1) * (latlon2 - latlon1) / (double) (pixel2 - pixel1));
    }

    private   int convertLatLonToPixel(double latlon1, double latlon2, int pixel1, int pixel2, double point_latlon) {
        return (pixel1 + (int) ((point_latlon - latlon1) * (double) (pixel2 - pixel1) / (latlon2 - latlon1)));
    }

    private   double getCeiling_LatLon_OfTile(double orig, double ref, double tileSizeInLatLon) {
        return orig + Math.ceil((ref - orig) / tileSizeInLatLon) * tileSizeInLatLon;
    }

    private   double getFloor_LatLon_OfTile(double orig, double ref, double tileSizeInLatLon) {
        return orig + Math.floor((ref - orig) / tileSizeInLatLon) * tileSizeInLatLon;
    }

    private   ArrayList<Integer> getCuttingPosition(double orig, double tileSizeInLatLon, double latlon_upper_bound, double latlon_lower_bound, int pixel_upper_bound, int pixel_lower_bound) {
        ArrayList<Integer> cuttingPosition = new ArrayList<Integer>();

        int tile_index_upper_bound = (int) ((latlon_upper_bound - orig) / tileSizeInLatLon);
        int tile_index_lower_bound = (int) ((latlon_lower_bound - orig) / tileSizeInLatLon);

        if (tile_index_upper_bound > 0) {
            for (int i = tile_index_lower_bound + 1; i <= tile_index_upper_bound; i++) {
                cuttingPosition.add(convertLatLonToPixel(latlon_upper_bound, latlon_lower_bound, pixel_upper_bound, pixel_lower_bound, orig + tileSizeInLatLon * ((double) i)));
            }
        } else {
            cuttingPosition.add(pixel_upper_bound);
        }

        return cuttingPosition;
    }

    private   int getMaxIdx_X(String path, int zoomLevel, String extention) {
        path += "Z" + (zoomLevel);
//                    path += (zoomLevel); //to deactivate after enc generation
        File f = new File(path + extention);
        if (f.exists()) {
            return -1;
        }

        int step = 1;
        int lowerVal = 0;
        int upperVal = 1;

        //find the upper value
        {
            boolean found = true;
            while (found) {
                f = new File(path + "_" + upperVal + "_0" + extention);
                found = f.exists();
                if (found) {
                    step = upperVal / 2;
                    lowerVal = upperVal;
                    upperVal *= 2;
                } else {
                    break;
                }
            }
        }

        {
            while (step > 0) {
                int tempVal = lowerVal + step;
                f = new File(path + "_" + tempVal + "_0" + extention);
                boolean found = f.exists();
                if (found) {
                    lowerVal = tempVal;
                } else {
                    upperVal = tempVal;
                }
                step /= 2;
            }
        }
        return upperVal;

    }

    private   int getMaxIdx_Y(String path, int zoomLevel, String extention) {
        path += "Z" + (zoomLevel);
//                    path += zoomLevel;
        File f = new File(path + extention);
        if (f.exists()) {
            return -1;
        }
        int step = 1;
        int lowerVal = 0;
        int upperVal = 1;

        //find the upper value
        {
            boolean found = true;
            while (found) {
                f = new File(path + "_0_" + upperVal + extention);
                found = f.exists();
                if (found) {
                    step = upperVal / 2;
                    lowerVal = upperVal;
                    upperVal *= 2;
                } else {
                    break;
                }
            }
        }

        {
            while (step > 0) {
                int tempVal = lowerVal + step;
                f = new File(path + "_0_" + tempVal + extention);
                boolean found = f.exists();
                if (found) {
                    lowerVal = tempVal;
                } else {
                    upperVal = tempVal;
                }
                step /= 2;
            }
        }
        return upperVal;
    }

      void purgeDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                purgeDirectory(file);
            }
            file.delete();
        }
    }

    private BufferedImage loadSubImage(ImageReader reader, ImageReadParam readParameters, int x, int y, int w, int h) {
        readParameters.setSourceRegion(new Rectangle(x, y, w, h));
        try {
            return reader.read(0, readParameters);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public   void test(String inputFilename, String outputFilename
    ) throws Exception {
        int left = 0;
        int top = 0;
        int width = 450;
        int height = 500;

        int tile_width = 100;
        int tile_height = 100;

        int zoom = 1;
        int img_width = zoom * width;
        int img_height = zoom * height;

        int n_width = img_width / tile_width + 1;
        int n_height = img_height / tile_height + 1;

        for (int idx_w = 0; idx_w < n_width; idx_w++) {
            int newX = left + idx_w * (int) ((float) (width * tile_width) / (float) img_width);
            int newW = (int) ((float) (width * tile_width) / (float) img_width);
            for (int idx_h = 0; idx_h < n_height; idx_h++) {
                int newY = top + idx_h * (int) ((float) (height * tile_height) / (float) img_height);
                int newH = (int) ((float) (height * tile_height) / (float) img_height);

                convertSVGToPNG(inputFilename + ".svg",
                        outputFilename + "Z" + zoom + "_" + idx_w + "_" + idx_h + ".png",
                        tile_width, tile_height, new Rectangle(newX, newY, newW, newH), newX, newY, newW, newH
                );
            }
        }

    }
}
