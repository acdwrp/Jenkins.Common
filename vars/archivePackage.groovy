def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    def artifacts = ""

    def type = includes.getClass()

    echo "${type}"

    for (i = 0; i< includes.size(); i++) {
        artifacts = (index == 0) ? artifacts + "${includes.getAt(i)}" : artifacts + ", ${includes.getAt(i)}"
    }

    echo artifacts

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}