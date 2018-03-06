package sns.model

sealed abstract class Platform(val name: String)

case object GCM extends Platform("GCM")