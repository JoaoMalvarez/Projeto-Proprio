package Ficha.RPG-backend;

public class Atributos {
    private int forca;
    private int destreza;
    private int constituicao;
    private int intelecto;
    private int sabedoria;
    private int carisma;

    public Atributos(int forca, int destreza, int constituicao, int intelecto, int sabedoria, int carisma) {
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.intelecto = intelecto;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getIntelecto() {
        return intelecto;
    }

    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }
}
