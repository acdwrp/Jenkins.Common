def call()
{
    def properties = readJSON file: ConfigLocation

    withAWS(credentials: properties.AWSCredentials, region: properties.AWSRegion) {
          timeout(time: 3, unit: 'MINUTES') {
            retry(count: 5) {
              s3Upload(file: properties.ZipPackageName, bucket: properties.AWSBucket, path: "${WorkspaceName}/${properties.ZipPackageName}")
            }
          }
        }
}