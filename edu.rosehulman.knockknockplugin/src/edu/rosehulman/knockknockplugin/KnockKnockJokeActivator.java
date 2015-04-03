package edu.rosehulman.knockknockplugin;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class KnockKnockJokeActivator extends AbstractUIPlugin  {
	// The plug-in ID
		public static final String PLUGIN_ID = "edu.rosehulman.knockknockplugin"; //$NON-NLS-1$

		// The shared instance
		private static KnockKnockJokeActivator plugin;
		
		/**
		 * The constructor
		 */
		public KnockKnockJokeActivator() {
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
		 */
		public void start(BundleContext context) throws Exception {
			super.start(context);
			plugin = this;
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
		 */
		public void stop(BundleContext context) throws Exception {
			plugin = null;
			super.stop(context);
		}

		/**
		 * Returns the shared instance
		 *
		 * @return the shared instance
		 */
		public static KnockKnockJokeActivator getDefault() {
			return plugin;
		}
}
