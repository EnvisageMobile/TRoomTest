package com.mpssdi.test.repository.local.entity;

import androidx.room.Embedded;

public class MachineWatch {
    @Embedded
    MachineResult machineResult;

    @Embedded
    Watch watch;

    public MachineResult getMachineResult() {
        return machineResult;
    }

    public void setMachineResult(MachineResult machineResult) {
        this.machineResult = machineResult;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }
}
