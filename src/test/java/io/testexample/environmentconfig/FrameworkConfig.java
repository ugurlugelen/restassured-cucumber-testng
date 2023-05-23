package io.testexample.environmentconfig;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/dev-config.properties",
        "file:${user.dir}/src/test/resources/staging-config.properties",
        "file:${user.dir}/src/test/resources/production-config.properties"})
public interface FrameworkConfig extends Config {
    @DefaultValue("staging")
    String environment();

    @Key("${environment}.url")
    String url();
    @Key("${environment}.username")
    String username();
    @Key("${environment}.password")
    String password();

}