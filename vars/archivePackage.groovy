def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    

    def p = includes.get(0)

    

    echo "${p}"

    


    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}