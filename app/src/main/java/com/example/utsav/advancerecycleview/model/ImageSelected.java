package com.example.utsav.advancerecycleview.model;

public class ImageSelected {
    private int image;
    private boolean isDesign;
    private boolean isFabric;
private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isDesign() {
        return isDesign;
    }

    public void setDesign(boolean design) {
        isDesign = design;
    }

    public boolean isFabric() {
        return isFabric;
    }

    public void setFabric(boolean fabric) {
        isFabric = fabric;
    }
}
