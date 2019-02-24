package cz.seliga.config

import cz.seliga.JpaExampleConfig
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Created by Vlasta on 2/23/2019.
 */

@Configuration
@EntityScan(basePackageClasses = [JpaExampleConfig::class, Jsr310JpaConverters::class])
@EnableJpaRepositories("cz.seliga.data.repository")

class SimpleConfiguration {
}
