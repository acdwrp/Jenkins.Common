def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    

    def p = includes[0..includes.size()]

    def type = p.getClass()

    echo "${type}"

    


    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}