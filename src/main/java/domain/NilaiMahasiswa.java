package domain;

// Student score model data for this program
public class NilaiMahasiswa {
    // atribute declaration
    private float tugas = 0;
    private float uts = 0;
    private float uas = 0;
    private float nilaiAkhir = 0;
    
    // Constructor
	public NilaiMahasiswa(float tugas, float uts, float uas){
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    // Getter And Setter
    public float getTugas() {
        return tugas;
    }

    public float getUts() {
        return uts;
    }

    public float getUas() {
        return uas;
    }

	public float getNilaiAkhir() {
	// Logic for final score
		return this.nilaiAkhir = (float)(tugas * 0.4 + uts * 0.3 + uas * 0.3) ;
	}	
	
	
	
}