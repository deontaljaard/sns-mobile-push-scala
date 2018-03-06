package sns.client

import java.util

import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.model._
import sns.model.{MobilePushMessage, Platform}

class SNSClientWrapper(val snsClient: AmazonSNS) {

  // Note: you'll probably want to use an automation tool like Ansible, Terraform, CloudFormation, etc. for creating application platforms
  def createPlatformApplication(applicationName: String, platform: Platform, credential: String): CreatePlatformApplicationResult = {
    val attributes = new util.HashMap[String, String]
    attributes.put("PlatformPrincipal", "")
    attributes.put("PlatformCredential", credential) // Server Api Key
    val platformApplicationRequest = new CreatePlatformApplicationRequest()
      .withName(applicationName)
      .withPlatform(platform.name)
      .withAttributes(attributes)
    snsClient.createPlatformApplication(platformApplicationRequest)
  }

  def createPlatformEndpoint(platformApplicationArn: String, token: String): CreatePlatformEndpointResult = {
    val platformEndpointRequest = new CreatePlatformEndpointRequest()
      .withPlatformApplicationArn(platformApplicationArn)
      .withToken(token)
    snsClient.createPlatformEndpoint(platformEndpointRequest)
  }

  def publishMessage(endpointArn: String, mobilePushMessage: MobilePushMessage): PublishResult = {
    val publishRequest = new PublishRequest()
      .withMessage(mobilePushMessage.toJsonString)
      .withTargetArn(endpointArn)
      .withMessageStructure("json")
    snsClient.publish(publishRequest)
  }
}
