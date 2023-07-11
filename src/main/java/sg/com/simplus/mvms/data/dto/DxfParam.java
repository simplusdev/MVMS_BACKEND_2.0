package sg.com.simplus.mvms.data.dto;

import org.springframework.web.multipart.MultipartFile;

public class DxfParam {

    private Double overlayMinLongitudeDbl;
    private Double overlayMaxLongitudeDbl;
    private Double overlayMinLatitudeDbl;
    private Double overlayMaxLatitudeDbl;
    private Double overlayMaxPixelXDbl;
    private Double overlayMinPixelXDbl;
    private Double overlayMaxPixelYDbl;
    private Double overlayMinPixelYDbl;
    private Double baseMapMinLongitudeDbl;
    private Double baseMapMaxLongitudeDbl;
    private Double baseMapMinLatitudeDbl;
    private Double baseMapMaxLatitudeDbl;
    private Integer displayScreenWidthInt;
    private Integer displayScreenHeightInt;
    private String zoomLevelsStr;
    private String generationModeStr;

    public Double getOverlayMinLongitudeDbl() {
        return overlayMinLongitudeDbl;
    }

    public void setOverlayMinLongitudeDbl(Double overlayMinLongitudeDbl) {
        this.overlayMinLongitudeDbl = overlayMinLongitudeDbl;
    }

    public Double getOverlayMaxLongitudeDbl() {
        return overlayMaxLongitudeDbl;
    }

    public void setOverlayMaxLongitudeDbl(Double overlayMaxLongitudeDbl) {
        this.overlayMaxLongitudeDbl = overlayMaxLongitudeDbl;
    }

    public Double getOverlayMinLatitudeDbl() {
        return overlayMinLatitudeDbl;
    }

    public void setOverlayMinLatitudeDbl(Double overlayMinLatitudeDbl) {
        this.overlayMinLatitudeDbl = overlayMinLatitudeDbl;
    }

    public Double getOverlayMaxLatitudeDbl() {
        return overlayMaxLatitudeDbl;
    }

    public void setOverlayMaxLatitudeDbl(Double overlayMaxLatitudeDbl) {
        this.overlayMaxLatitudeDbl = overlayMaxLatitudeDbl;
    }

    public Double getOverlayMaxPixelXDbl() {
        return overlayMaxPixelXDbl;
    }

    public void setOverlayMaxPixelXDbl(Double overlayMaxPixelXDbl) {
        this.overlayMaxPixelXDbl = overlayMaxPixelXDbl;
    }

    public Double getOverlayMinPixelXDbl() {
        return overlayMinPixelXDbl;
    }

    public void setOverlayMinPixelXDbl(Double overlayMinPixelXDbl) {
        this.overlayMinPixelXDbl = overlayMinPixelXDbl;
    }

    public Double getOverlayMaxPixelYDbl() {
        return overlayMaxPixelYDbl;
    }

    public void setOverlayMaxPixelYDbl(Double overlayMaxPixelYDbl) {
        this.overlayMaxPixelYDbl = overlayMaxPixelYDbl;
    }

    public Double getOverlayMinPixelYDbl() {
        return overlayMinPixelYDbl;
    }

    public void setOverlayMinPixelYDbl(Double overlayMinPixelYDbl) {
        this.overlayMinPixelYDbl = overlayMinPixelYDbl;
    }

    public Double getBaseMapMinLongitudeDbl() {
        return baseMapMinLongitudeDbl;
    }

    public void setBaseMapMinLongitudeDbl(Double baseMapMinLongitudeDbl) {
        this.baseMapMinLongitudeDbl = baseMapMinLongitudeDbl;
    }

    public Double getBaseMapMaxLongitudeDbl() {
        return baseMapMaxLongitudeDbl;
    }

    public void setBaseMapMaxLongitudeDbl(Double baseMapMaxLongitudeDbl) {
        this.baseMapMaxLongitudeDbl = baseMapMaxLongitudeDbl;
    }

    public Double getBaseMapMinLatitudeDbl() {
        return baseMapMinLatitudeDbl;
    }

    public void setBaseMapMinLatitudeDbl(Double baseMapMinLatitudeDbl) {
        this.baseMapMinLatitudeDbl = baseMapMinLatitudeDbl;
    }

    public Double getBaseMapMaxLatitudeDbl() {
        return baseMapMaxLatitudeDbl;
    }

    public void setBaseMapMaxLatitudeDbl(Double baseMapMaxLatitudeDbl) {
        this.baseMapMaxLatitudeDbl = baseMapMaxLatitudeDbl;
    }

    public Integer getDisplayScreenWidthInt() {
        return displayScreenWidthInt;
    }

    public void setDisplayScreenWidthInt(Integer displayScreenWidthInt) {
        this.displayScreenWidthInt = displayScreenWidthInt;
    }

    public Integer getDisplayScreenHeightInt() {
        return displayScreenHeightInt;
    }

    public void setDisplayScreenHeightInt(Integer displayScreenHeightInt) {
        this.displayScreenHeightInt = displayScreenHeightInt;
    }

    public String getZoomLevelsStr() {
        return zoomLevelsStr;
    }

    public void setZoomLevelsStr(String zoomLevelsStr) {
        this.zoomLevelsStr = zoomLevelsStr;
    }

    public String getGenerationModeStr() {
        return generationModeStr;
    }

    public void setGenerationModeStr(String generationModeStr) {
        this.generationModeStr = generationModeStr;
    }
}
