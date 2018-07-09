def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes

    def artifacts = ""

    def isMap = includes instanceof java.util.LinkedHashMap

    echo "${isMap}"

    def type = includes.toList().getClass()

    echo "${type}"

    echo artifacts

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}