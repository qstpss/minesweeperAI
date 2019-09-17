package com.qstpss;

import com.qstpss.ai.ClickPhase;
import com.qstpss.ai.GameDifficulty;
import com.qstpss.ai.MineSweeperBot;
import com.qstpss.ai.Phase;

public class AppMain {
    public static void main(String[] args) {
        MineSweeperBot mineSweeperBot = new MineSweeperBot(Driver.INSTANCE.get());
        mineSweeperBot.startNewGame(GameDifficulty.BEGINNER);
        Phase clickPhase = new ClickPhase(mineSweeperBot);
        clickPhase.doJob();
    }
}
