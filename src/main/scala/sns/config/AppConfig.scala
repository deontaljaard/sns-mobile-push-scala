package sns.config

import com.typesafe.config.ConfigFactory

object AppConfig {
  private val config = ConfigFactory.load()

  object AwsConfig {
    private val awsConfig = config.getConfig("aws")
    private val snsConfig = awsConfig.getConfig("sns")

    lazy val snsAccessKey: String = snsConfig.getString("accessKey")
    lazy val snsSecretKey: String = snsConfig.getString("secretKey")
    lazy val snsRegion: String = snsConfig.getString("region")
  }

  object GCMConfig {
    private val gcmConfig = config.getConfig("gcm")

    lazy val serverApiKey: String = gcmConfig.getString("serverApiKey")
    lazy val clientRegisterId: String = gcmConfig.getString("clientRegisterId")
  }
}
