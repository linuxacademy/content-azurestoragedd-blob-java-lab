package com.linuxacademy.azurestoragedd.blob;

import com.azure.storage.blob.*;

public class Main {

    public static void main(String[] args) {
        //Get the Azure Storage service connect string from the CONNECT_STRING environment variable.
        String connectString = System.getenv("CONNECT_STRING");
        String containerName = "records";
        String blobName = "fridge";
        
        // BlobServiceClient will interface with the Azure Blob Service.
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectString).buildClient();

        // Get a BlobContainerClient to interface with the container.
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        
        // Get a BlobClient to interface with the blob.
        BlobClient blobClient = containerClient.getBlobClient(blobName);
        
        System.out.println("Current Contents of the Breakroom Fridge:");
        //Download the contents of the file directly to the System.out output stream, causing the blob contents to be printed to the console.
        blobClient.download(System.out);
    }

}