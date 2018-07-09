def call()
{
    def properties = readJSON file: ConfigLocation

    def includes = properties.Artifacts.Includes.toList()

    

    def sub = includes.subList(0, includes.size() -1)

    for (i = 0; i< sub.size(); i++) {
       def incl = sub[i]

       echo incl
    }


    zip(glob: properties.ArtifactsToPack, zipFile: properties.ZipPackageName)
    archiveArtifacts(artifacts: properties.ZipPackageName, onlyIfSuccessful: true, fingerprint: true)
}