def call()
{
    def properties = readJSON file: ConfigLocation

    withAWS(credentials: properties.AWSCredentials, region: properties.AWSRegion) {
          timeout(time: 3, unit: 'MINUTES') {
            retry(count: 5) {
              s3Upload(file: properties.ZipPackageName, bucket: properties.AWSBucket, path: "${WorkspaceName}/${properties.ZipPackageName}")

              // Write an useful file, which is needed to be archived.
              def metaFile = "${WorkspaceName}/meta.json"

              writeFile file: metaFile, text: "This file is useful, need to archive it. ${BUILD_NUMBER}"

              s3Upload(file: metaFile, bucket: properties.AWSBucket, path: "${WorkspaceName}/meta.json")
            }

          }
        }
}