package io.jenkins.plugins.casc.yaml;

import hudson.ExtensionList;
import java.util.Optional;
import javax.annotation.Nonnull;
import jenkins.model.Jenkins;
import org.apache.commons.lang.StringUtils;

public class MergeStrategyFactory {
    public static MergeStrategy getMergeStrategy(@Nonnull String name) {
        String strategyName = StringUtils.isEmpty(name) ? MergeStrategy.DEFAULT_STRATEGY : name;

        ExtensionList<MergeStrategy> mergeStrategyList = Jenkins.getInstance()
            .getExtensionList(MergeStrategy.class);
        Optional<MergeStrategy> opt = mergeStrategyList.stream().
            filter(strategy -> strategy.getName().equals(strategyName)).findFirst();
        return opt.orElse(null);
    }
}
