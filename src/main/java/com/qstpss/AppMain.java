package com.qstpss;

import com.qstpss.ai.GameProcess;
import com.qstpss.ai.phases.ClickPhase;
import com.qstpss.ai.GameDifficulty;
import com.qstpss.ai.MineSweeperBot;
import com.qstpss.ai.phases.Phase;

public class AppMain {
    public static void main(String[] args) {
        MineSweeperBot mineSweeperBot = new MineSweeperBot(Driver.INSTANCE.get());
        GameProcess gameProcess = new GameProcess(mineSweeperBot);
        gameProcess.start(GameDifficulty.BEGINNER);
    }
}
