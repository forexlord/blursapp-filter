import { NativeModule, requireNativeModule } from 'expo';

import { FilterModuleEvents } from './FilterModule.types';

declare class FilterModule extends NativeModule<FilterModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<FilterModule>('FilterModule');
