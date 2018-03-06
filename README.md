# sns-mobile-push-scala
A project to understand how SNS Mobile Push operates.

## Dependencies
The project uses the AWS Java SDK to communicate with AWS SNS. The rest of the dependencies can be viewed in project/Dependencies.scala. Lastly, the project requires SBT.

## Getting started
The project assumes that you have completed the steps in this [guide](https://docs.aws.amazon.com/sns/latest/dg/mobile-push-gcm.html).

To run the project, use:
```bash
sbt "runMain sns.Main"
```

Note: the code is not production ready - practices like exception handling, validation, etc. still need to be added.