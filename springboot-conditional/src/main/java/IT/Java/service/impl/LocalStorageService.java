package IT.Java.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import IT.Java.service.StorageService;

@Component
@ConditionalOnProperty(value = "storage.type", havingValue = "local", matchIfMissing = true)
public class LocalStorageService implements StorageService {

	@Value("${storage.local:/var/static}")
	String localStorageRootDir;

	final Logger logger = LoggerFactory.getLogger(getClass());

	private File localStorageRoot;

	@PostConstruct
	public void init() {
		logger.info("Intializing local storage with root dir: {}", this.localStorageRootDir);
		this.localStorageRoot = new File(this.localStorageRootDir);
	}

	@Override
	public InputStream openInputStream(String uri) throws IOException {
		File targetFile = new File(this.localStorageRoot, uri);
		return new BufferedInputStream(new FileInputStream(targetFile));
	}

	@Override
	public String store(String extName, InputStream input) throws IOException {
		String fileName = UUID.randomUUID().toString() + "." + extName;
		File targetFile = new File(this.localStorageRoot, fileName);
		try (OutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile))) {
			input.transferTo(output);
		}
		return fileName;
	}
}
