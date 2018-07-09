def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    def artifacts = ""

    for (i = 0; i< includes.size(); i++) {
       def incl = includes[i]

       artifacts = (index == 0) ? artifacts + "${listValue}" : artifacts + ", ${listValue}"

       echo artifacts
    }

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}