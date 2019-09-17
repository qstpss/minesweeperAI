package com.qstpss.ai;

public final class ClickPhase implements Phase {
    private MineSweeperBot mineSweeperBot;

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
