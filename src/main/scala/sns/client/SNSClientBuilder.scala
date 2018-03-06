package sns.client

import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.regions.Regions
import com.amazonaws.services.sns.{AmazonSNS, AmazonSNSClientBuilder}
import sns.config.AppConfig

object SNSClientBuilder {

  private lazy val accessKeyId = AppConfig.AwsConfig.snsAccessKey
  private lazy val secretAccessKey = AppConfig.AwsConfig.snsSecretKey
  private lazy val snsRegion = AppConfig.AwsConfig.snsRegion

  private lazy val basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey)
  private lazy val awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(basicAWSCredentials)

  lazy val snsClient: AmazonSNS = AmazonSNSClientBuilder.standard()
    .withRegion(Regions.fromName(snsRegion))
    .withCredentials(awsStaticCredentialsProvider).build()
}
