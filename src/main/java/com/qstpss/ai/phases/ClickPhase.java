package com.qstpss.ai.phases;

import com.qstpss.ai.MineSweeperBot;

public final class ClickPhase extends Phase {

    private ClickPhase(){

    }

    public ClickPhase(MineSweeperBot mineSweeperBot) {
        this.mineSweeperBot = mineSweeperBot;
    }

    @Override
    public void doJob() {
        mineSweeperBot.clickRandomCell();
        mineSweeperBot.readToGameFieldObj();
    }

}
