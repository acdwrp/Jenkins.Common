def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    def aml = ""

    for (i = 0; i< includes.size(); i++) {
       def incl = includes.get(i)

       aml = (index == 0) ? aml + "${incl}" : aml + ", ${incl}"

       echo aml
    }

    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}