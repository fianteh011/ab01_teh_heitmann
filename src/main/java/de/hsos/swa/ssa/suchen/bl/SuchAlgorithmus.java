package de.hsos.swa.ssa.suchen.bl;

import de.hsos.swa.ssa.suchen.dal.KeywordMatching;
import de.hsos.swa.ssa.suchen.dal.SemanticMatching;
import de.hsos.swa.ssa.suchen.dal.WarenSuche;

public enum SuchAlgorithmus {
    KEYWORD, SEMANTIC;

    public WarenSuche whichAlgo()  {

        switch (this) {
            case KEYWORD:
                return new KeywordMatching();
            case SEMANTIC:
                return new SemanticMatching();
            default:
                return null;
        }

    }
}
