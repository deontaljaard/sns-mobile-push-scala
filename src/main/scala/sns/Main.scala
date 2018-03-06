package sns

import sns.client.{SNSClientBuilder, SNSClientWrapper}
import sns.config.AppConfig
import sns.model._

object Main {
  def main(args: Array[String]): Unit = {
    val snsClientWrapper = new SNSClientWrapper(SNSClientBuilder.snsClient)
    val platformApplicationResult = snsClientWrapper.createPlatformApplication("sns-demo", GCM, AppConfig.GCMConfig.serverApiKey)
    println(s"Created platform application with ARN '${platformApplicationResult.getPlatformApplicationArn}'")
    val platformEndpointResult = snsClientWrapper.createPlatformEndpoint(platformApplicationResult.getPlatformApplicationArn, AppConfig.GCMConfig.clientRegisterId)
    println(s"Created platform endpoint with ARN '${platformEndpointResult.getEndpointArn}'")
    val publishResult = snsClientWrapper.publishMessage(platformEndpointResult.getEndpointArn, MobilePushMessage(GCM, AndroidMessage()))
    println(s"Published message with message ID '${publishResult.getMessageId}'")
  }
}
