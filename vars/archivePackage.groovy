def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    def includedPattern = ""

    for (i = 0; i< includes.size(); i++) {
       def item = includes.get(i)

       includedPattern = (i == 0) ? includedPattern + "${item}" : includedPattern + ", ${item}"
    }

    echo includedPattern

    zip(glob: includedPattern, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}