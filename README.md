# QR Code Generator

A Spring Boot application that generates QR codes and stores them in AWS S3. This project demonstrates the integration of Google's ZXing library for QR code generation and AWS S3 for storage.

### Prerequisites

- Java 21 JDK
- Maven
- Docker
- AWS Account with S3 access
- AWS CLI configured with appropriate credentials

### Environment Variables

Create a `.env` file in the project root with the following variables:

```env
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=your_region
AWS_BUCKET_NAME=your_bucket_name
```

### Running the Application

#### Local Development

1. Create the `.env` file as described above
2. Build the project:
   ```bash
   mvn clean package
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

#### Docker Deployment

1. Build the Docker image:
   ```bash
   docker build -t qrcode-generator:X.X . 
   ```
> Remember to replace the version and image name if you want

2. Run the container:
   ```bash
   docker run --env-file .env -p 8080:8080 qrcode-generator:X.X 
   ```

> Remember to replace the .env file path to the path of your environment file that you created.

### AWS S3 Configuration

1. Create an S3 bucket in your AWS account
2. Update the `AWS_BUCKET_NAME` in your `.env` file or Docker run command
3. Ensure your AWS credentials have appropriate permissions to access the S3 bucket

## API Endpoints

### POST /qrcode
Generate a QR code from the provided text and store it in AWS S3. The QR code will be generated as a PNG image with dimensions of 200x200 pixels.

**Parameters**

| Name | Required | Type | Description |
|------|----------|------|-------------|
| `text` | required | string | The text content to be encoded in the QR code. This can be any string value that you want to convert into a QR code. |

**Response**

```json
{
    "url": "https://your-bucket.s3.your-region.amazonaws.com/random-uuid"
}
```

**Error Response**

If an error occurs during QR code generation or S3 upload, the API will return a 500 Internal Server Error.
