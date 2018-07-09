def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes

    def artifacts = ""

    includes.eachWithIndex {listValue, index=> artifacts = (index == 0) ? artifacts + "${listValue}" : artifacts + ", ${listValue}"}

    echo artifacts

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}