package com.qstpss.ai.phases;

import com.qstpss.ai.MineSweeperBot;

public class SearchingPhase extends Phase {

    private SearchingPhase() {

    }

    public SearchingPhase(MineSweeperBot mineSweeperBot) {
        this.mineSweeperBot = mineSweeperBot;
    }

    @Override
    public void doJob() {
        mineSweeperBot.searchAndMineAdjacentCells();
        mineSweeperBot.readToGameFieldObj();
    }
}
