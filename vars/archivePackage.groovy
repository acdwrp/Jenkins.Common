def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList().indexed()

    def artifacts = ""

    def type = includes.getClass()

    echo "${type}"

    includes.eachWithIndex {listValue, index=> artifacts = (index == 0) ? artifacts + "${listValue}" : artifacts + ", ${listValue}"}

    echo artifacts

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}