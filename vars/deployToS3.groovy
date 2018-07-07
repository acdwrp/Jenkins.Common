def call(Map config)
{
    echo config.file

    echo DepolymentProperties.AWSBucket

    withAWS(credentials: DepolymentProperties.AWSCredentials, region: DepolymentProperties.AWSRegion) {
          timeout(time: 3, unit: 'MINUTES') {
            retry(count: 5) {
              s3Upload(file: DepolymentProperties.ZipPackageName, bucket: DepolymentProperties.AWSBucket, path: "${WorkspaceName}/${DepolymentProperties.ZipPackageName}")
            }

          }

        }
}