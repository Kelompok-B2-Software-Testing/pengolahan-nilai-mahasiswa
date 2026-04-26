package domain;

import data.State;
import utils.InputUtils;
import utils.StateMachine;

public class Screen {

    // declaration
    private final StateMachine sMachine;
    private final InputUtils inputUtils = new InputUtils();
    private ServiceGrade serviceGrade = new ServiceGrade();

    // constructor
    public Screen(StateMachine stateMachine) {
        this.sMachine = stateMachine;
    }

    // Procedure for showing input screen
    public NilaiMahasiswa InputNilai() {
        // Change state to input
        if (sMachine.getStateNow() != State.Input) {
            sMachine.setStateNow(State.Input);
        }

        float iTugas = inputUtils.inputFloat("Input nilai tugas");
        float iUts = inputUtils.inputFloat("Input nilai uts");
        float iUas = inputUtils.inputFloat("Input nilai uas");
        // Ensure state back to running
        if (sMachine.getStateNow() != State.Running) {
            sMachine.setStateNow(State.Running);
        }
        return new NilaiMahasiswa(iTugas, iUts, iUas);
    }

    // Procedure for showing recap score and grading
    public void RekapNilai(NilaiMahasiswa nilaiMahasiswa) {
        // Ensure state for running
        if (sMachine.getStateNow() != State.Running) {
            sMachine.setStateNow(State.Running);
        }
        System.out.println("Hasil Grading\n");
        float input = nilaiMahasiswa.getNilaiAkhir();
        System.out.println(serviceGrade.getGrade(input));
        System.out.println(serviceGrade.getStatus(input));
    }
}
