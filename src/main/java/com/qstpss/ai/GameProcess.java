package com.qstpss.ai;

import com.qstpss.ai.phases.ClickPhase;
import com.qstpss.ai.phases.Phase;
import com.qstpss.ai.phases.SearchingPhase;

public class GameProcess {
    private MineSweeperBot mineSweeperBot;
    private Phase clickPhase;
    private Phase searchPhase;

    private GameProcess() {

    }

    public GameProcess(MineSweeperBot mineSweeperBot) {
        this.mineSweeperBot = mineSweeperBot;
        clickPhase = new ClickPhase(mineSweeperBot);
        searchPhase = new SearchingPhase(mineSweeperBot);
    }

    public void start(GameDifficulty difficulty) {
        mineSweeperBot.startNewGame(difficulty);
        clickPhase.doJob();
        searchPhase.doJob();
    }

}
