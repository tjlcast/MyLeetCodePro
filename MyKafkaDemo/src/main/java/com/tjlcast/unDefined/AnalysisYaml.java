package com.tjlcast.unDefined;

import java.io.FileInputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

// yaml配置文件路径默认为根目录的kafka.yaml文件
public class AnalysisYaml {

	//private String yamlPath = System.getProperty("user.dir") +  System.getProperty("file.separator") + ("kafka.yaml");
	private String yamlPath = AnalysisYaml.class.getClassLoader().getResource("")+ ("kafka.yaml");

	public AnalysisYaml() {
	}

	/**
	 * 生成配置文件解析对象
	 * 
	 * @param
	 */
	public AnalysisYaml(String yamlPath) {
		this.yamlPath = yamlPath;
	}

	public String getYamlPath() {
		return yamlPath;
	}

	public void setYamlPath(String yamlPath) {
		this.yamlPath = yamlPath;
	}

	/**
	 * 通过生产者名，读取配置文件中的指定生产者配置，生成生产者配置文件实体类
	 * 
	 * @param ，所用生产者的名字
	 * @return 配置文件实体类
	 */
	public ProducerProperties getProducerProperties(String producerName) {

		Yaml yaml = new Yaml();
		ProducerProperties producerProperties;
		try  {
			Map<String, Map<String, Object>> yamlMap = yaml.loadAs(new FileInputStream(yamlPath), Map.class);
			producerProperties = (ProducerProperties) yamlMap.get("producer").get(producerName);
		} catch (Exception e) {
			return null;
		}

		return producerProperties;

	}

	// 测试
	public static void main(String args[]) throws Exception{
	//	AnalysisYaml test = new AnalysisYaml();
//		FileInputStream f = new FileInputStream("D:/project/device-access/target/classes/kafka.yaml");
//		System.out.println(AnalysisYaml.class.getResource(""));
//		System.out.println(AnalysisYaml.class.getClassLoader().getResource(""));
//		System.out.println(test.getProducerProperties("producerTest").getBootstrapServers());
//		System.out.println(test.getProducerProperties("producerTest").getTopic());

        System.out.println(System.getProperty("user.dir") + System.getProperty("file.separator") + ("kafka.yaml"));

        System.out.println(AnalysisYaml.class.getClassLoader().getResource("")+ ("kafka.yaml"));
    }

}
