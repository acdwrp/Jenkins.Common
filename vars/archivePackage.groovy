def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList().indexed()

    def artifacts = ""

    def type = includes.getClass()

    echo "${type}"

    

    echo artifacts

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}