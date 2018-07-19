def call(def config)
{
    def properties = readJSON file: ConfigLocation

    def metaFile = "meta.json"

    withAWS(credentials: properties.AWSCredentials, region: properties.AWSRegion) {
        timeout(time: 3, unit: 'MINUTES') {
            retry(count: 5) {
              writeFile file: metaFile, text: "{ \"LatestVersion\" :  ${BUILD_NUMBER}}"

              s3Upload(file: metaFile, bucket: properties.AWSBucket, path: "${WorkspaceName}/${config.environment}/meta.json")
            }
          }
        }       
}