package ru.neoflex.dossier.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.neoflex.dossier.data.enums.Theme;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class EmailSendStrategyFactory {

    private Map<Theme, EmailSendStrategy> strategies;

    @Autowired
    public EmailSendStrategyFactory(Set<EmailSendStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public EmailSendStrategy findStrategy(Theme theme) {
        return strategies.get(theme);
    }

    private void createStrategy(Set<EmailSendStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getTheme(), strategy));
    }
}
