package domain;

import data.State;
import utils.StateMachine;

// main app domain
public class GradingMahasiswa {

    // declaration
    StateMachine stateMachine = new StateMachine();
    Screen uiScreen = new Screen(stateMachine);
    NilaiMahasiswa nilaiMahasiswa;
    ServiceGrade serviceGrade;

    // Running program
    public void Run() {
        stateMachine.setStateNow(State.Running);
        nilaiMahasiswa = uiScreen.InputNilai();
        uiScreen.RekapNilai(nilaiMahasiswa);
    }
}
