package it.naples.TorreseQL.states;

import it.naples.TorreseQL.model.QueryInfo;
import it.naples.TorreseQL.model.iDontKnow;

import java.util.function.Function;

public abstract class MatchState extends AbstractState {

    private final String[] keywords;
    private final Function<QueryInfo, AbstractState> nextStateTransition;
    private int currentIndex = 1;

    public MatchState(QueryInfo queryInfo, String[] keywords, Function<QueryInfo, AbstractState> nextStateTransition) {
        super(queryInfo);

        this.keywords = keywords;
        this.nextStateTransition = nextStateTransition;
    }

    public MatchState(QueryInfo queryInfo, String[] keywords, Function<QueryInfo, AbstractState> nextStateTransition, int currentIndex) {
        super(queryInfo);

        this.keywords = keywords;
        this.nextStateTransition = nextStateTransition;
        this.currentIndex = currentIndex;
    }

    public AbstractState nextTransaction(String token) throws iDontKnow {
        if (token.equalsIgnoreCase(keywords[currentIndex])) {
            currentIndex++;
            if (currentIndex == keywords.length) return nextStateTransition.apply(queryInfo);

            return this;
        }

        throw new iDontKnow(keywords[currentIndex], token);
    }
}