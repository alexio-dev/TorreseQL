package it.naples.TorreseQL.states;

import it.naples.TorreseQL.model.QueryInfo;
import it.naples.TorreseQL.model.iDontKnow;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerState extends AbstractState {
    private final Consumer<String> tokenConsumer;
    private final Function<QueryInfo, AbstractState> transitionFunction;

    public ConsumerState(QueryInfo queryInfo, Consumer<String> tokenConsumer, Function<QueryInfo, AbstractState> transitionFunction) {
        super(queryInfo);

        this.tokenConsumer = tokenConsumer;
        this.transitionFunction = transitionFunction;
    }

    @Override
    public AbstractState transitionToNextState(String token) throws iDontKnow {
        tokenConsumer.accept(token);

        return transitionFunction.apply(queryInfo);
    }

}