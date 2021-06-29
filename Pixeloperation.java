
/**
 * Beschreiben Sie hier die Klasse Pixeloperation.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Pixeloperation implements Bildoperation
{
   private int opCount=5; //number of operations available
    // IDs der geometrischen Operationen
    // Jede geometrische Operation erhält eine eindeutige Zahl,
    // um sich diese besser merken zu können, wird die Zahl einer Konstanten 'static final'
    // mit leserlichem Namen 'OP_<NameDerOperation>' zugeordnet.
    public static final int OP_Nil = 0;
    public static final int Graustufen = 1;
    
    // ID der aktuell aktiven geometrischen Operation.
    private int op = OP_Nil;

    /**
     * Erstellt eine mit der aktuell aktiven geometrische Operation veränderte Kopie eines Bildes.
     *
     * @param originalBild Das zu verändernde Bild
     * @return Das geänderte Bild
     */
    
    public Picture apply(Picture originalBild)
    {
        // Pro geometrische Operation wird hier eine Zeile benötigt, die die entprechende Operation ausführt.
        switch( this.op ){
            case Graustufen: return spiegelHorizontal(originalBild);
            
            case OP_Nil:
            default: return originalBild.copy();
        }    
    }

    /**
     * Wählt eine Operation zum Ausführen via apply aus.
     *
     * @param op Nummer der auszuführenden Operation.
     */
    public void setOperation(int op)
    {
        if(op > this.opCount ) return;
        this.op = op;
    }

    // Anleitung zur Erstellung einer weiteren geometrischen Operation.
    // 1. Erstelle eine Methode mit der Signatur "public Picture meineGeometrischeOperation( Picture originalBild )",
    //    (siehe Beispiele unten)
    // 2. Passe wenn nötig die Methode apply an (siehe oben)
    //    und erstelle falls nötig eine neue Konstante "int OP_meineGeometrischeOperation".
    //

    /** 
     * Spiegelt das Bild, so dass rechts und links getauscht werden
     * @param originalBild Ein Bild (Picture), das gespiegelt werden soll
     */
    public Picture spiegelHorizontal(Picture originalBild) {
        int breite = originalBild.getWidth();
        int hoehe  = originalBild.getHeight();

        int[][] pixel = originalBild.getPixelsTable();
        int[][] pixelNeu = new int[breite][hoehe];

        for(int x=0; x < breite; x++) {
            for(int y=0;y < hoehe; y++) {
                pixelNeu[x][y] = pixel[(breite-1)-x][y];
            }
        }
        Picture neuesBild = originalBild.copy();
        neuesBild.setPixelsArray(pixelNeu);
        return neuesBild;
    }

    
}

