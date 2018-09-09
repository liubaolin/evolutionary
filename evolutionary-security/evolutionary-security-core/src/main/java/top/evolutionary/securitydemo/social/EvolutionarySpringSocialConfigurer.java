package top.evolutionary.securitydemo.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author richey
 */
public class EvolutionarySpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessorUrl;

    public EvolutionarySpringSocialConfigurer(String filterProcessorUrl) {
        this.filterProcessorUrl = filterProcessorUrl;
    }

    @Override
    protected <T> T postProcess(T object) {

        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessorUrl);
        return (T) filter;
    }
}
